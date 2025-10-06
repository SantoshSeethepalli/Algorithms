# Notepad

Merge Sort, Quick Sort, and Heap Sort are comparison-based sorting algorithms that achieve an asymptotic time complexity of O(n log n) (Big-O notation).

    Quick Sort:
    Has a large constant factor for small input sizes.
    
    Merge Sort:
    Extra space, which can be significant for big inputs.
    
    Heap Sort:
    Has a large constant factor and poor locality of reference.

Notes:

Constant factor is expressed as C * n log(n) + K, where C is the constant factor.

Poor locality of reference: The algorithm cannot predict which element will be accessed next, making it harder for the operating system to optimize memory access.

<details>
<summary>Time & Space Complexities</summary>

| Algorithm              | Best Case    | Average Case   | Worst Case     | Space Complexity | Stable | In-Place |
|------------------------|--------------|----------------|----------------|------------------|--------|-----------|
| Selection Sort         | O(n²)        | O(n²)           | O(n²)           | O(1)             | No     | Yes       |
| Bubble Sort            | O(n)         | O(n²)           | O(n²)           | O(1)             | Yes    | Yes       |
| Insertion Sort         | O(n)         | O(n²)           | O(n²)           | O(1)             | Yes    | Yes       |
| Quick Sort             | O(n log n)   | O(n log n)      | O(n²)           | O(log n)!        | No     | Yes       |
| Merge Sort             | O(n log n)   | O(n log n)      | O(n log n)      | O(n)             | Yes    | No        |
| Dual-Pivot Quick Sort  | O(n log n)   | O(n log n)      | O(n²)           | O(log n)!        | No     | Yes       |
| Heap Sort              | O(n log n)   | O(n log n)      | O(n log n)      | O(1)             | No     | Yes       |
| 3-Way Quick Sort       | O(n)?        | O(n log n)      | O(n²)           | O(log n)!        | No     | Yes       |
| TimSort                | O(n)         | O(n log n)      | O(n log n)      | O(n)             | Yes    | No        |
| IntroSort              | O(n log n)   | O(n log n)      | O(n log n)      | O(log n)         | No     | Yes       |
| Counting Sort          | O(n + k)     | O(n + k)        | O(n + k)        | O(k)             | Yes    | No        |
| Radix Sort             | O(d·(n + k)) | O(d·(n + k))    | O(d·(n + k))    | O(n + k)         | Yes    | No        |
| Bucket Sort            | O(n + k)     | O(n + k)        | O(n²)           | O(n + k)         | Yes    | No        |

! - Recursion stack space  
? - Becomes O(n) when all elements are equal

</details>


<details>
<summary>When to Use Sorting Algorithms</summary>

> **Selection Sort**  
> Very small arrays; few swaps needed.

> **Bubble Sort**  
> Nearly sorted small arrays.

> **Insertion Sort**  
> The best for small arrays.
> Small or nearly sorted arrays.

> **3-Way Quick Sort**  
> Many duplicate elements.

> **TimSort**  
> Real-world data.

> **Counting Sort**  
> Integers in limited range.

> **Bucket Sort**  
> Uniformly distributed data, floating-point numbers.

</details>




