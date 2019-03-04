#!/usr/bin/env groovy

node {
    checkout scm
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