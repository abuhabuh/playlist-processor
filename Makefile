### Vars
DOCKER_REPO := johnwang412
DOCKER_STACK_LOCAL := playlist-test


### Targets

# Clean stuff
clean-docker: clean-docker-stop-stack clean-docker-imgs
clean-docker-stop-stack:
	docker stack rm ${DOCKER_STACK_LOCAL}
	# sleep for 2 seconds to let stack remove itself
	sleep 2
clean-docker-imgs:
	docker images -q --filter dangling=true | xargs docker rmi -f
	## Filter image by reference not working
	#docker images -q --filter reference='${DOCKER_REPO}/${DOCKER_STACK_LOCAL}' | xargs docker rmi -f


# Docker stuff
docker-local-pl:
	(cd playlist-processor && \
		sbt docker:publishLocal)
docker-local: docker-local-pl


# Deploy stuff
deploy-local: clean-docker
	docker stack deploy -c docker-compose.yml ${DOCKER_STACK_LOCAL}

