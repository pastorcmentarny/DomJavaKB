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
import logging
import sys
import traceback

from flask import Flask, jsonify, request

app = Flask(__name__)
logger = logging.getLogger('app')
APP_NAME = 'DB'


@app.route("/actuator/health")
def healthcheck():
    return jsonify({"status": "UP", "app": APP_NAME})


@app.route("/tube/update", methods=['POST'])
def update_metrics_for():
    logger.info('updating metrics {}'.format(request.get_json(force=True)))
    result = request.get_json(force=True)
    print(result)
    return jsonify({"status": "OK"})


@app.route('/tube/station/<name>')
def get_station_information_for(name="Uxbridge"):
    return jsonify({"result": "OK",
                    "name": name,
                    "status": "VISITED",
                    "passedDate": "20210101",
                    "visitedDate": "20210101",
                    "thisYearVisitedDate": "20210101"
                    })


@app.route("/tube/stations/")
def get_all_stations():
    return jsonify('{"result":"OK",'
                   '"name" : "Amersham";'
                   '"status" : "VISITED";'
                   '"passedDate" : "20210101";'
                   '"visitedDate" : "20210101";'
                   '"thisYearVisitedDate" : "20210101";'
                   '}')


@app.route("/")
def stats():
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
