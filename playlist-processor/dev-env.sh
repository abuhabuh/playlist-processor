#!/bin/bash
#
# Script to init env vars for local sbt run
# todo: get rid of this - move into a config somewhere or integrate with sbt

export SEED_SYSTEM_NAME=playlist-system
export SEED_SYSTEM_HOST=127.0.0.1
export SEED_SYSTEM_PORT=2551
export NETTY_TCP_HOST=127.0.0.1
export NETTY_TCP_PORT=0
export NETTY_TCP_BIND_HOST=127.0.0.1
export NETTY_TCP_BIND_PORT=0
