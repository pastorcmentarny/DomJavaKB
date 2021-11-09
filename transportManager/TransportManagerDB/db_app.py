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
import platform
import sys
import traceback

from flask import Flask, jsonify, request, abort, Response
from werkzeug.exceptions import HTTPException

import storage_service
import tube_service

app = Flask(__name__)
logger = logging.getLogger('app')
APP_NAME = 'DB'


@app.route("/actuator/health")
def healthcheck():
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
    result = tube_service.get_station_data_for_(station_name)
    if result == {}:
        abort(404)
    return jsonify(result)


@app.route('/tube/station/passed/<station_name>/<date>')
def update_station_to_passed(station_name: str, date: str):
    updated = tube_service.update_station_to_passed(station_name, date)
    if updated:
        return Response('"status": "OK"}', status=201, mimetype='application/json')
    else:
        abort(404)


@app.route("/tube/stations/")
def get_all_stations():
    if platform.node() == "DOM-DESKTOP":
        return jsonify({"stations": storage_service.load_data(
            r'B:\GitHub\DomKB\transportManager\TransportManagerDB\stations.txt')})
    else:
        return jsonify({"stations": storage_service.load_data(r'home/pi/stations.txt')})


@app.errorhandler(HTTPException)
def handle_exception(http_exception):
    response = http_exception.get_response()
    response.data = json.dumps({
        "code": http_exception.code,
        "name": http_exception.name,
        "description": http_exception.description,
    })
    response.content_type = "application/json"
    return response


@app.route("/")
def main_route():
    start = datetime.datetime.now()

    stop = datetime.datetime.now()

    delta = stop - start
    print(f'It took {int(delta.total_seconds() * 1000)} ms.')

    return jsonify({"status": "OK"})


if __name__ == '__main__':
    logger.info('Starting web server')

    try:
        app.config['JSONIFY_PRETTYPRINT_REGULAR'] = True
        app.config['JSON_AS_ASCII'] = False
        app.run(host='0.0.0.0', port=18003, debug=True)  # host added so it can be visible on local network

    except KeyboardInterrupt as keyboard_exception:
        print('Received request application to shut down.. goodbye. {}'.format(keyboard_exception))
        logging.info('Received request application to shut down.. goodbye!', exc_info=True)
    except Exception as exception:
        logger.error('Something went badly wrong\n{}'.format(exception), exc_info=True)
        sys.exit(1)
    except BaseException as disaster:
        msg = 'Shit hit the fan and application died badly because {}'.format(disaster)
        print(msg)
        traceback.print_exc()
        logger.fatal(msg, exc_info=True)
