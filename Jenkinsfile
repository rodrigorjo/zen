#!/usr/bin/env groovy

node {
    stage('Build') {
        sh './gradlew build'
    }
    stage('Test') {
        echo 'Building....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}