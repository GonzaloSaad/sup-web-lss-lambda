# Mat Sup - Least Square Solver 

##### AWS Lambda that solves problems with least square method.

## Build
This application main artifact is an spring boot über jar.
Build command:
```
./gradlew clean build
```

## Build for local run/debug
This application main artifact is an spring boot über jar.
Build command:
```
./gradlew clean buildForLocalRun
```
This task will take up to 3 minutes. It just takes the `.jar` file and decompress it into the build directory.


## AWS SAM local 

For run and debug in your local machine.

Invoke the function by logic ID.
```
sam local invoke "routeWriterLocal"
```

Invoke the function with a JSON event.
```
sam local invoke "LeastSquareSolver" -e event.json 
```

 Here `profile` is your aws profile in `.aws/credentials`.
```
sam local invoke "LeastSquareSolver" -e event.json --profile profile
```
 
Invoke the function with a JSON event and your profile, in debug mode. Here replace `port` with the port number you want.
```
sam local invoke -d port "LeastSquareSolver" -e event.json --profile profile
```


## Json format (example).

For a message with two functions, the format should be the following.

```
{
  "x": "1;2;3",
  "y": "4;5;6",
  "function": "C1*x+C2*x^2",
  "method":"GAUSS",
  "pivot":"TOTAL"
}
```
