#!/usr/bin/env groovy

node {
    stage('Build') {
        sh './gradlew clean build'
    }
    stage('Test') {
        echo 'Building....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}