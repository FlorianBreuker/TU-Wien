#include "list.h"

#include <stdio.h>
#include <stdlib.h>

// creation
node* createHead(char *data) {
  node* head = malloc(sizeof(node)); // acquire memomry for head node
  head->data = data;                // set data pointer
  head->next = NULL;                // set next to NULL to signal it is not valid (this is the last element)
  head->prev = NULL;
  return head;
}

// helper function, only visible in this file
static node* findLast(node *head) {
  if (head->next == NULL) { // no next node, this must be the last
    return head;
  } else {
    return findLast(head->next); // recursive function call
  }
}

// create new node for data and append to the end of the list
node* append(node* head, char *data) {
  node *newNode = createHead(data);
  node *last = findLast(head);
  last->next = newNode;
  newNode->prev = last;
  newNode->next = NULL;
  return head;
}

// helper function, only visible in this file
static node *findFirst(node *head) {
  if (head->prev == NULL) {
    return head;
  } else {
    return findFirst(head->prev);
  }	
}

node* prepend(node *head, char *data) {
  node *newNode = createHead(data);
  node *first = findFirst(head);
  first->prev = newNode;
  newNode->next = first;
  return head;
}

// print, one element per line
static void printPrime(int i, node *head) {
  printf("%d: %s\n", i, head->data);
  if (head->next != NULL) {
    printPrime(i + 1, head->next);
  }
}

void print(node *head) {
  node *first = findFirst(head);
  printPrime(0, first);
}

// move
node* forward(node *head) {
  if (head->next != NULL){
    return head->next;
  } else { // return NULL to signal that move is not possible
    return NULL;
  }
}

node* backward(node *head) {
  if (head->prev != NULL){
    return head->prev;
  } else { // return NULL to signal that move is not possible
    return NULL;
  }
}

// modify
// remove the given element, merge the list parts and
// return the element before the one we just removed (if it exists)
//     or the element after  the one we just removed (if it exists, but no previous element exists)
//     or NULL (if this was the only elemnt)
node* delete(node *head) {
  if (head->next == NULL && head->prev == NULL) {
    free(head);
    return NULL;
  }

  node *prev = backward(head);
  node *next = forward(head);

  if (prev == NULL) {
    next->prev = NULL;
    free(head);
    return next;
  } else if (next == NULL) {
    prev->next = NULL;
    free(head);
    return prev;
  } else {
    next->prev = prev;
    prev->next = next;
    free(head);
    return prev;
  }
}
