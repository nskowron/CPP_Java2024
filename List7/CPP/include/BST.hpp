#ifndef BST_HPP
#define BST_HPP

#include <vector>
#include <string>

template <typename T>
class BST
{
private:
    template <typename E>
    class Node
    {
    public:
        E value;
        Node<E>* left;
        Node<E>* right;
        Node<E>* parent;

        Node(E val) : value(val) {}
    };

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
    //void printRec() const;
};

#include <BST.cpp>

#endif