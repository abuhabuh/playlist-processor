### Vars
DOCKER_STACK_LOCAL := playlist-test


### Targets

docker-local-pl:
	(cd playlist-processor && \
		sbt docker:publishLocal)

docker-local: docker-local-pl

deploy-local:
	docker stack deploy -c docker-compose.yml playlist-test
