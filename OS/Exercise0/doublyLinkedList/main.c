#include <stdio.h>

#include "list.h"

int main (int argc, char** argv) {
  // create a linked list containg three elements
  node* head = createHead("first element");
  append(head, "second element");
  append(head, "third element");

  printf("Test PREPEND\n");
  prepend(head, "prepended element");
  printf("%s\n",backward(head)->data);
  printf("Test PRINT\n");
  print(head);
  printf("Test DELETE\n");
  delete(head);
  print(head);

  return 0;
}
