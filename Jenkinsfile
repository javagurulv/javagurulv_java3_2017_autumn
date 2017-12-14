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

}
