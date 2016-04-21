#!/usr/bin/env bash

set -x

if [ -n "$TRAVIS_TAG" ]; then
    mvn package -Drevision=''
elif [ "$TRAVIS_BRANCH" = "master" ]; then
    mvn package
fi
