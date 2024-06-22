#ifndef BST_HPP
#define BST_HPP

#include <vector>
#include <string>

template <typename T>
class BST
{
private:
    template <typename T>
    class Node
    {
        T value;
        Node<T>* left;
        Node<T>* right;
        Node<T>* parent;

        Node(T val) : value(val) {}
    }

    Node<T>* root;

public:
    void insert(const T&);
    void remove(const T&);
    bool search(const T&) const;
    std::vector<std::string> print() const;

private:
    void insertRec(Node<T>*, const T&);
    Node<T>* removeRec(Node<T>*, const T&);
    bool searchRec(Node<T>*, const T&) const;
    void printRec() const;
};

#endif