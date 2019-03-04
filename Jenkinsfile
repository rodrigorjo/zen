#!/usr/bin/env groovy

node {

    def gradle = "./gradlew"

    checkout scm
    stage('Clean') {
            sh '${gradle} clean'
            echo 'Cleaning....'
        }
    stage('Build') {
        sh '${gradle} build -x test'
    }
    stage('Test') {
        sh "${gradle} test"
        echo 'Testing....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}