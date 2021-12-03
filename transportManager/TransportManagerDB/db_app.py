#!/usr/bin/env python3
# -*- coding: utf-8 -*-

"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* Github:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""
import datetime
import json
import logging
import sys
import traceback

from flask import Flask, jsonify, request, abort, Response
from werkzeug.exceptions import HTTPException

import db_config
import storage_service
import tube_service

app = Flask(__name__)
logger = logging.getLogger('app')
APP_NAME = 'DB'


@app.route("/actuator/health")
def healthcheck():
    logger.debug("Get healthcheck")
    return jsonify({"status": "UP", "app": APP_NAME})


@app.route("/tube/update", methods=['POST'])
def update_metrics_for():
    result = request.get_json(force=True)
    logger.info('updating station {}'.format(result))
    updated = tube_service.update_station_info(result)
    if updated:
        return Response(result, status=201, mimetype='application/json')
    else:
        abort(404)


@app.route('/tube/station/<station_name>')
def get_station_information_for(station_name):
    logger.info(f"Getting station data for {station_name}")
    result = tube_service.get_station_data_for_(station_name)
    if result == {}:
        abort(404)
    return jsonify(result)


@app.route('/tube/station/passed/<station_name>/<date>')
def update_station_to_passed(station_name: str, date: str):
    logger.info(f"Update station to passed for {station_name}")
    updated = tube_service.update_station_to_passed(station_name, date)
    if updated:
        return Response('"status": "OK"}', status=201, mimetype='application/json')
    else:
        abort(404)


@app.route("/tube/stations/")
def get_all_stations():
    logger.info(f"Getting all stations data")
    return jsonify({"stations": storage_service.load_data(db_config.get_path())})


@app.errorhandler(HTTPException)
def handle_exception(http_exception):
    response = http_exception.get_response()
    response.data = json.dumps({
        "code": http_exception.code,
        "name": http_exception.name,
        "description": http_exception.description,
    })
    logger.warning(f"Something went wrong f{response.data}")
    response.content_type = "application/json"
    return response


@app.route("/")
def main_route():
    return jsonify({"status": "OK"})


if __name__ == '__main__':
    logging_level = logging.DEBUG
    logging_format = "%(levelname)s\t\t:: %(asctime)s :: %(message)s"
    logging_filename = f"tm_db_logs_{datetime.date.today()}.txt"
    logging.basicConfig(level=logging_level, format=logging_format, filename=logging_filename)
    logger.info('Starting web server')

    try:
        app.config['JSONIFY_PRETTYPRINT_REGULAR'] = True
        app.config['JSON_AS_ASCII'] = False
        # host added so it can be visible on local network
        app.run(host='0.0.0.0', port=db_config.server_port, debug=True)

    except KeyboardInterrupt as keyboard_exception:
        print('Received request application to shut down.. goodbye. {}'.format(keyboard_exception))
        logging.info('Received request application to shut down.. goodbye!', exc_info=True)
    except Exception as exception:
        msg = f"Something went badly wrong: {exception}"
        print(msg)
        logger.error(msg, exc_info=True)
        sys.exit(1)
    except BaseException as disaster:
        msg = f"Shit hit the fan and application died badly because {disaster}"
        print(msg)
        logger.error(f"Something went badly wrong: {disaster}", exc_info=True)
        traceback.print_exc()
        logger.fatal(msg, exc_info=True)
