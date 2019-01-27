import wikipedia


def instant_search(key):
    return wikipedia.summary(key, sentences=1)


def get_options(key):
    return wikipedia.search(key)


def search(key):
    return wikipedia.page(key).content

