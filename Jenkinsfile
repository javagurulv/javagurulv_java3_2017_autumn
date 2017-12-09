node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build snapshot --parallel'
	}
	stage ('Test') {
		bat 'gradlew.bat test --parallel'
	}
	stage ('Publish') {
		bat 'gradlew.bat snapshot publish --parallel'
	}
	stage ('Deploy to local') {
		dir('deployment') {
			bat 'deployLocal.bat'
		}
	}
	stage ('Release') {
		bat 'gradlew.bat final publish --parallel --stacktrace'
	}
}