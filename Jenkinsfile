pipeline {
    agent any
    tools{
        maven 'maven 3.8.6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/labinas/atmlocator-heroku']]])
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    bat 'docker build -t labinas/atmlocator .'
                }
            }
        }
        stage('Push Docker Image to HUB'){
            steps{
                script{
                    bat 'docker login -u labinas -p dckr_pat_bmz0PCXC9wl9LmW-uvQnSePQBNg'

                    bat 'docker push labinas/atmlocator'
                }
            }
        }
        stage('Deploy to K8S'){
            steps{
                script{
                    kubernetesDeploy configs: 'deploymentservice.yaml', kubeConfig: [path: ''], kubeconfigId: 'k8sconfig', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
                }
            }
        }
    }
}