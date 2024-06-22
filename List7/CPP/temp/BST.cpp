#include <iostream>
#include <string>
#include <sstream>

#include <BST.hpp>

template <typename T>
void BST<T>::insert(const T& value)
{
    std::cout << "Inserting value: " << value << std::endl;
    if (root == nullptr)
    {
        std::cout << "Inserting root" << std::endl;
        root = new Node(value);
    }
    else
    {
        std::cout << "Inserting node" << std::endl;
        insertRec(root, value);
    }
}

template <typename T>
void BST<T>::remove(const T& value)
{
    root = removeRec(root, value);
}

template <typename T>
bool BST<T>::search(const T& value) const
{
    return searchRec(root, value);
}

// template <typename T>
// std::string BST<T>::print() const
// {
//     return printRecursive(root, 0);
// }

template <typename T>
void BST<T>::insertRec(Node<T>* node, const T& value)
{
    if (value < node->value)
    {
        if (node->left == nullptr)
        {
            node->left = new Node(value);
            node->left->parent = node;
        }
        else
        {
            insertRec(node->left, value);
        }
    }
    else
    {
        if (node->right == nullptr)
        {
            node->right = new Node(value);
            node->right->parent = node;
        }
        else
        {
            insertRec(node->right, value);
        }
    }
}

template <typename T>
typename BST<T>::template Node<T>* BST<T>::removeRec(Node<T>* node, const T& value)
{
    if (node == nullptr)
    {
        return nullptr;
    }

    if (value < node->value)
    {
        node->left = removeRec(node->left, value);
    }
    else if (value > node->value)
    {
        node->right = removeRec(node->right, value);
    }
    else
    {
        if (node->left == nullptr && node->right == nullptr)
        {
            delete node;
            node = nullptr;
        }
        else if (node->left == nullptr)
        {
            Node<T>* temp = node;
            node = node->right;
            node->parent = temp->parent;
            delete temp;
        }
        else if (node->right == nullptr)
        {
            Node<T>* temp = node;
            node = node->left;
            node->parent = temp->parent;
            delete temp;
        }
        else
        {
            Node<T>* temp = node->right;
            while (temp->left != nullptr)
            {
                temp = temp->left;
            }
            node->value = temp->value;
            node->right = removeRec(node->right, temp->value);
        }
    }

    return node;
}

template <typename T>
bool BST<T>::searchRec(Node<T>* node, const T& value) const
{
    if (node == nullptr)
    {
        return false;
    }
    if (value < node->value)
    {
        return searchRec(node->left, value);
    }
    else if (value > node->value)
    {
        return searchRec(node->right, value);
    }
    else
    {
        return true;
    }
}

// template <typename T>
// std::string BST<T>::printRec(Node *node, int indent)
// {
//     std::stringstream ss;
    
//     if (node != nullptr)
//     {
//         ss << printRecursive(node->right, indent + 4);
//         for (int i = 0; i < indent; i++)
//         {
//             ss << " ";
//         }
//         ss << StringConverter::valToString<T>(node->value) << "\n";
//         ss << printRecursive(node->left, indent + 4);
//     }

//     return ss.str();
// }

