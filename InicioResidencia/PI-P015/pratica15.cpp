#include <iostream>
#include <vector>
#include <algorithm>

class Set {
private:
    std::vector<std::string> items;

public:
    int putItem(std::string item) {
        if (std::find(items.begin(), items.end(), item) != items.end()) {
            return 0;
        }
        items.push_back(item);
        return 1;
    }

    bool existItem(std::string item) {
        return std::find(items.begin(), items.end(), item) != items.end();
    }

    int delItem(std::string item) {
        auto it = std::find(items.begin(), items.end(), item);
        if (it != items.end()) {
            items.erase(it);
            return 1;
        }
        return 0;
    }

    void showItems() {
        std::cout << "Conjunto: { ";
        for (const auto &item : items) {
            std::cout << item << " ";
        }
        std::cout << "}\n";
    }
};

int main() {
    Set mySet;

    mySet.putItem("apple");
    mySet.putItem("banana");
    mySet.putItem("orange");
    mySet.putItem("apple");

    mySet.showItems();

    std::cout << "Item 'banana' existe? " << (mySet.existItem("banana") ? "Sim" : "Não") << std::endl;

    mySet.delItem("banana");
    mySet.showItems();

    std::cout << "Item 'banana' existe? " << (mySet.existItem("banana") ? "Sim" : "Não") << std::endl;

    // Aguardar a entrada do usuário antes de fechar o terminal
    std::cout << "Pressione Enter para sair...";
    std::cin.get(); // Aguarda a entrada do usuário

    return 0;
}
