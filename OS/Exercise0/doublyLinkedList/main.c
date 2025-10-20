#include <stdio.h>

#include "list.h"

int main (int argc, char** argv) {
  // create a linked list containg three elements
  node* head = createHead("first element");
  head = append(head, "second element");
  head = append(head, "third element");

  printf("Test PREPEND\n");
  head = prepend(head, "prepended element");
  printf("%s\n",head->data);
  printf("Test PRINT\n");
  print(head);
  printf("Test DELETE\n");
  head = delete(head);
  print(head);

  return 0;
}