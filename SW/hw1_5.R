start <- c("H","H","H","H","H","H","H","H","H","H")
omega <- list()

# counts up bit wise (H is 0, T is 1)
for (i in 0:2^length(start)-1){
  num <- i
  cur <- start
  for (j in 1:10){
    if (num %% 2 == 1){
      cur[j] <- "T"
    }
    num <- num %/% 2 # integer division
  }
  omega <- append(omega,list(cur))
}

A <- list()

isPrime <- function(number){
  if (number < 2) {
    return(FALSE)
  }
  if (number == 2){
    return(TRUE)
  }
  for (i in 2:(number-1)){
    if (number %% i == 0){
      return(FALSE)
    }
  }
  return(TRUE)
}


isPrimeSequence <- function(flips){
  sequenceCount <- 1
  clear <- 0
  for (i in 1:(length(flips))){
    if (i < clear){
      next 
    }
    # checks if the next characters are different
    for(j in i:(length(flips))){
      if (flips[i] != flips[j]){
        sequenceCount <- sequenceCount + 1
        clear <- j # due to some R stuff, i was not able to i <- j
        break
      }
    }
  }
  return(isPrime(sequenceCount))
}

for (a in omega){
  print(isPrimeSequence(a))
  if (isPrimeSequence(a)){
    A <- append(A,list(a))
  }
}

A

P <- length(A) / length(omega)

P