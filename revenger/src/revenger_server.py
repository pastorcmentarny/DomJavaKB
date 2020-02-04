import sys

from flask import Flask, jsonify, url_for, send_file, request, render_template

app = Flask(__name__)

APP_NAME = "Revenger"


@app.route("/hc")
def healthcheck():
    return jsonify({"status": "UP",
                    "app": APP_NAME})


if __name__ == '__main__':
    print('Starting web server')

    try:
        app.run(host='0.0.0.0', debug=True)  # host added so it can be visible on local network

    except Exception as e:
        print(e)
        sys.exit(0)
