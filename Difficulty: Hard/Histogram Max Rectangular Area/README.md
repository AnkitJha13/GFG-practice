<h2><a href="https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?page=1&category=Stack&difficulty=Hard&sortBy=submissions">Histogram Max Rectangular Area</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">You are given a <strong>histogram</strong> represented by an array <strong>arr</strong>, where each element of the array denotes the <strong>height</strong> of the bars in the histogram. All bars have the same <strong>width of 1 unit</strong>. </span></p>
<p><span style="font-size: 18px;">Your task is to find the <strong>largest</strong> rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [6, 2, 5, 4, 5, 1, 6]</span><span style="font-size: 18px;">
<strong>Output: </strong>12<strong>
Explanation:</strong> In this example the largest area would be 12 of height 4 and width 3. We can achieve this area by choosing 3rd, 4th and 5th bars.</span><img src="http://d1hyf4ir1gqw6c.cloudfront.net/wp-content/uploads/histogram1.png" alt="">
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [7, 2, 8, 9, 1, 3, 6, 5]</span><span style="font-size: 18px;">
<strong style="font-size: 18px;">Output: </strong><span style="font-size: 18px;">16</span><strong style="font-size: 18px;">
Explanation: </strong><span style="font-size: 18px;">In this example the largest area would be 16 of height 8 and width 2. We can achieve this area by choosing 3rd and 4th bars.<br></span></span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [3]</span><span style="font-size: 18px;">
<strong>Output: </strong>3<strong>
Explanation: </strong>In this example the largest area would be 3 of height 3 and width 1.</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ arr.size() ≤ 10<sup>5</sup><br>0 ≤ arr[i] ≤ 10<sup>3</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Stack</code>&nbsp;<code>Data Structures</code>&nbsp;