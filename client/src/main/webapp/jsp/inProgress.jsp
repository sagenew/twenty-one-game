<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blackjack</title>
</head>
<body>

<div>
    <h1>Dealers Hand</h1>
    ${game.printDealersHand()}

    <h2>Totals</h2>
    ${game.printDealersTotals()}
</div>

<div>
    <h1>Players Hand</h1>
    ${game.printPlayersHand()}

    <h2>Totals</h2>
    ${game.printPlayersTotals()}
</div>

<div>
    <form method="POST">
        <input value="Hit" name="hit" type="submit" id="hitButton" class="submit_button">
        <input value="Stand" name="stand" type="submit" id="standButton" class="submit_button">
    </form>
</div>

</body>
</html>