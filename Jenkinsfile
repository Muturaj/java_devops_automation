pipeline {
     environment {
     imagename = "muttud/devops_intigration_update"
     registryCredential = 'muttud'

  }
    agent any
    tools{
        maven 'maven-3.8.6'
    }

    stages {
        stage('build maven') {
            steps {
                echo 'Hello World Started'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Muturaj/java_devops_automation']]])
                echo 'checkout done'
                bat 'mvn clean install'
            }
        }
        stage('docker build image') {
            steps {
                script {
                    echo 'docker build image'
                    bat 'docker build -t muttud/devops_intigration_update .'
                   //dockerImage = docker.build imagename
                  // args '-v $HOME/.m2:/root/.m2'

                }

            }
        }
        stage('push to docker hub') {
            steps {
                script {
                   docker.withRegistry( '', registryCredential ) {
                        echo 'login success'

                   //dockerImage.push('latest')
              }

                bat 'docker push muttud/devops_intigration_update'


                }

            }
        }
        stage('deploy to k8s') {
            steps {
                script {

                  kubernetesDeploy configs: 'spring-boot-app.yaml', kubeConfig: [path: ''], kubeconfigId: 'kubeid', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
                }
            }
        }
    }
}