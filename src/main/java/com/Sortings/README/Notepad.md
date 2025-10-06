# Notepad

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




