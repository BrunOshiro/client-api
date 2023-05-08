local-env-create:
	docker-compose -f stack.yaml up -d
	sleep 3
	docker cp data/ddl.sql postgres:/var/lib/postgresql/data
	docker cp data/ddl.sql postgres:/var/lib/postgresql/data

local-env-destroy:
	docker-compose -f stack.yaml down