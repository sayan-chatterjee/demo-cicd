node("local") {
	stage 'Checkout'
	checkout scm
	
	stage 'Compile'
	bat 'mvn -e clean compile'
	
	stage 'Package'
	bat 'mvn -DskipTests=true clean package'

	stage 'Start Application'
	bat 'java -jar **/target/demo-0.0.1-SNAPSHOT.jar'
} 
	