from flask import Flask, render_template
from jinja2 import Template

"""
* Author Dominik Symonowicz
* WWW:	https://dominiksymonowicz.com/welcome
* IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
* GitHub:	https://github.com/pastorcmentarny
* Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
* LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
"""
app = Flask(__name__)


def print_simple_jinja2_template():
    template = Template("Hello {{ something }}!")
    print(template.render(something="Dominik"))

    template = Template("My favorite numbers: {% for n in range(1,10) %}{{n}} " "{% endfor %}")
    print(template.render())


@app.route("/")
def template_test():
    num_list = [0, 1, 2, 3, 4, 5, 6]
    return render_template('template.html', my_string="Dom Template", my_list=num_list)


def run_simple_flask_app():
    print("wow")


def main():
    print("Jinja2 template ")
    print_simple_jinja2_template()
    run_simple_flask_app()


if __name__ == '__main__':
    app.run(debug=True)
    main()
