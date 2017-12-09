node {
	stage ('Checkout') {
		checkout scm
	}
	stage ('Build') {
		bat 'gradlew.bat clean build snapshot --parallel --stacktrace'
	}
	stage ('Test') {
		bat 'gradlew.bat test --parallel --stacktrace'
	}
	stage ('Publish') {
		bat 'gradlew.bat snapshot publish --parallel --stacktrace'
	}
	stage ('Deploy to local') {
		dir('deployment') {
			bat 'deployLocal.bat'
		}
	}
	stage ('Release') {
		bat 'git status'
		bat 'gradlew.bat final --parallel'
	}
}