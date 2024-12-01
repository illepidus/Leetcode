# Java Operator Precedence Table

<table>
<tr><th>Precedence</th><th>Operator</th><th>Type</th><th>Associativity</th></tr>
<tr>
  <td>15</td>
  <td>()<br>[]<br>·</td>
  <td>Parentheses<br>Array subscript<br>Member selection<br></td>
  <td>Left to Right</td>
</tr>
<tr>
  <td>14</td>
  <td>++<br>--</td>
  <td>Unary post-increment<br>Unary post-decrement</td>
  <td>Left to Right</td>
</tr>
 <tr>
  <td>13</td>
  <td>++<br>--<br>+<br>-<br>!<br>~<br>( <i>type</i> )</td>
  <td>Unary pre-increment<br>Unary pre-decrement<br>Unary plus<br>Unary minus<br>Unary logical negation<br>Unary bitwise complement<br>Unary type cast</td>
  <td>Right to left</td>
</tr>
<tr>
  <td>12</td>
  <td> * <br> / <br> % </td>
  <td>Multiplication<br>Division<br>Modulus</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>11</td>
  <td>+<br>-</td>
  <td>Addition<br>Subtraction</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>10</td>
  <td>&lt;&lt;<br>&gt;&gt;<br>&gt;&gt;&gt;</td>
  <td>Bitwise left shift<br>Bitwise right shift with sign extension<br>Bitwise right shift with zero extension</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>9</td>
  <td>&lt;<br>&lt;=<br>&gt;<br>&gt;=<br>instanceof</td>
  <td>Relational less than<br>Relational less than or equal<br>Relational greater than<br>Relational greater than or equal<br>Type comparison (objects only)</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>8</td>
  <td>==<br>!=</td>
  <td>Relational is equal to<br>Relational is not equal to</td>
  <td>Left to right</td>
</tr>
 <tr>
  <td>7</td>
  <td>&amp;</td>
  <td>Bitwise AND</td>
  <td>Left to right</td>
</tr>
 <tr>
  <td>6</td>
  <td>^</td>
  <td>Bitwise exclusive OR</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>5</td>
  <td>|</td>
  <td>Bitwise inclusive OR</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>4</td>
  <td>&amp;&amp;</td>
  <td>Logical AND
  </td>
  <td>Left to right</td>
</tr>
 <tr>
  <td>3</td>
  <td>||</td>
  <td>Logical OR</td>
  <td>Left to right</td>
</tr>
<tr>
  <td>2</td>
  <td>? :</td>
  <td>Ternary conditional</td>
  <td>Right to left</td>
</tr>
<tr>
  <td>1</td>
  <td>=<br>+=<br>-=<br>*=<br>/=<br>%=</td>
  <td>Assignment<br>Addition assignment<br>Subtraction assignment<br>Multiplication assignment<br>Division assignment<br>Modulus assignment</td>
  <td>Right to left</td>
</tr>
</table>
