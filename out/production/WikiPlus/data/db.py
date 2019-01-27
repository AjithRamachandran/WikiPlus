import sqlite3

connection = sqlite3.connect('user_data.db')


def add_user(f_name, l_name, u_name, p_word):
    pass


def sign_in(u_name, p_word):
    pass


def update_data(option, new_data):
    pass


def search_data(u_name, password):
    pass


connection.close()
