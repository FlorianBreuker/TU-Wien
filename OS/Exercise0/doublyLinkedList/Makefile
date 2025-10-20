# Compiler and flags variables
CC = gcc
CFLAGS = -std=c99 -Wall -pedantic

.PHONY: all clean

all: main

main: main.o list.o
	$(CC) $(CFLAGS) -o $@ $^

# Pattern rule for object files
%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<

# Additional dependencies
main.o: list.h
list.o: list.h

# Clean target
clean:
	rm -f *.o main