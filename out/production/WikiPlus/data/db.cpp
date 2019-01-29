#include <stdio.h>
#include <string>
#include <sqlite3.h>
#include "../data/database.h"

char* passWord;

static int callback(void *NotUsed, int argc, char **argv, char **azColName) {
       passWord = argv[0];
       return 0;
}

JNIEXPORT jint JNICALL Java_database_createUser(JNIEnv *, jobject, jstring, jstring, jstring, jstring); {
    sqlite3 *db;
    char* zErr = 0;
    int rc;
    std::string sql;

    rc = sqlite3_open("user_data.db", &db);

    if(rc) {
        return -1;
    }

    sql = "insert into user_data (fName, lName, uName, pWord) " \
           "values ('" + fName + "','" + lName + "','" + uName + "','" + pWord + "'); ";
    rc = sqlite3_exec(db, sql.c_str(), callback, 0, &zErr);
    sqlite3_free(zErr);
    sqlite3_close(db);
    return 0;
}

JNIEXPORT jstring JNICALL Java_database_searchUser(JNIEnv *, jobject, jstring, jstring); {
    sqlite3 *db;
    char* zErr = 0;
    int rc;
    std::string sql;

    rc = sqlite3_open("user_data.db", &db);

    if(rc) {
        return "Error";
    }

    sql = "SELECT pWord from user_data WHERE username='" + uName + "'";

    rc = sqlite3_exec(db, sql.c_str(), callback, NULL, &zErr);

    sqlite3_free(zErr);
    sqlite3_close(db);

    return passWord;
}