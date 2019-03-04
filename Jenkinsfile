#!/usr/bin/env groovy

node {

    def gradle = "./gradlew"

    checkout scm
    stage('Clean') {
            sh './gradlew clean'
            echo 'Cleaning....'
        }
    stage('Build') {
        sh './gradlew build -x test'
    }
    stage('Test') {
        sh "./gradlew test"
        echo 'Testing....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}