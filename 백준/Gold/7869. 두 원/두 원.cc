#include <cmath>
#include <iostream>
// using namespace std;

double GetDegree(double d, double r1, double r2);
double GetDistance(double x1, double y1, double x2, double y2);

double GetDegree(double d, double r1, double r2) {
    // 제2 코사인 으로 사잇각 구하기
    double theta = acos((pow(r1, 2) + pow(d, 2) - pow(r2, 2)) / (2 * r1 * d));

    double degree_2 = sin(2 * theta) * pow(r1, 2) / 2;

    double degree_1 = theta * pow(r1, 2);

    ;
    return degree_1 - degree_2;
}

double GetDistance(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
}

int main() {
    double x1, y1, r1, x2, y2, r2;
    std::cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
    /*두 원의 중심사이 거리*/
    double distance = GetDistance(x1, y1, x2, y2);

    double area;
    if (r1 + r2 <= distance) {
        area = 0.0;
    } else if (abs(r1 - r2) >= distance) {
        area = M_PI * pow(std::min(r1, r2), 2);
    } else {
        area = GetDegree(distance, r1, r2) + GetDegree(distance, r2, r1);
    }

    std::cout.precision(3);
    std::cout << std::fixed << area << std::endl;
}