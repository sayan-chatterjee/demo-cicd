taskkill /f /fi "WindowTitle eq demo-cicd" /t
title demo-cicd
java -jar ./target/demo-0.0.1-SNAPSHOT.jar