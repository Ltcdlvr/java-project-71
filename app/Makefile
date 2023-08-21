.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

build:
	./gradlew clean build

run:
	./gradlew run

report:
	./gradlew jacocoTestReport

build-run: build run

.PHONY: build