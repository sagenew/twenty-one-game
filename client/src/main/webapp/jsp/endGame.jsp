<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlackJack</title>
</head>
<body>

<div>
    <h1>Dealers Hand</h1>
    ${game.printDealersHand()}

    <h2>Totals</h2>
    ${game.printDealersTotals()}

    ${game.printDealersResult()}

</div>

<div>
    <h1>Players Hand</h1>
    ${game.printPlayersHand()}

    <h2>Totals</h2>
    ${game.printPlayersTotals()}

    ${game.printPlayersResult()}

</div>

<div>
    <h1>Result</h1>
    ${game.printResult()}
</div>

<div>
    <form method="POST">
        <input value="Deal" name="deal" type="submit" id="dealButton" class="submit_button">
    </form>
</div>

</body>
</html>