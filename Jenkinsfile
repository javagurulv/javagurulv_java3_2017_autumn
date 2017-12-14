node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build snapshot --parallel --no-daemon'
	}
	stage ('Test') {
		bat 'gradlew.bat test --parallel --no-daemon'
	}
	stage ('Publish') {
		bat 'gradlew.bat snapshot --parallel --no-daemon'
	}
	//stage ('Deploy to local') {
	//	dir('deployment') {
	//		bat 'deployLocal.bat'
	//	}
	//}
	stage ('Clean Workspace') {
		cleanUp() 
	}
}

def cleanUp() {
    stage('Delete workspace from Jenkins') {
        step([$class: 'WsCleanup'])
    }
}