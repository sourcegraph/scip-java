#!/usr/bin/env bash
/packagehub --host 0.0.0.0 --port $PORT --src /src --coursier /coursier --postgres.username=$DB_USER --postgres.password=$DB_PASS --postgres.url=$DB_URL
