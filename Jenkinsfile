#!/usr/bin/env groovy

node {

    def gradle = "./gradlew"

    checkout scm
    stage("Clean") {
            sh "${gradle} clean"
            echo "Cleaning...."
        }
    stage("Build") {
        sh "${gradle}build -x test"
    }
    stage("Test") {
        sh "${gradle} test"
        echo "Testing...."
    }
    stage("Deploy") {
        if (currentBuild.result == null || currentBuild.result == "SUCCESS") { 1
            echo "Deploy....
            echo "Running ${env.BUILD_ID} for job ${env.JOB_NAME} on ${env.JENKINS_URL}"
        }
    }
}