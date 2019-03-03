import wikipedia
import json
import sys

data = {}

def instant_search(key):
    data['summary'] = wikipedia.summary(key, sentences=1)


def get_options(key):
    data['options'] =  wikipedia.search(key)


def search(key):
    data['search'] = wikipedia.page(key).content


def save_data():
    key = sys.argv[1]
    instant_search(key)
    get_options(key)
    with open('../Wikiplus/data/data.json', 'w') as outfile:
        json.dump(data, outfile)

save_data()