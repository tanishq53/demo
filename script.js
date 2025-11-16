document.getElementById('converter-form').addEventListener('submit', async function(e) {
    e.preventDefault();

    const from = document.getElementById('from').value.toUpperCase();
    const to = document.getElementById('to').value.toUpperCase();
    const amount = document.getElementById('amount').value;

    try {
        const response = await fetch(`https://tanishq53.github.io/demo//api/convert?from=${from}&to=${to}&amount=${amount}`);
        const text = await response.text();
        document.getElementById('result').innerText = text;
    } catch (error) {
        document.getElementById('result').innerText = "Error fetching conversion.";
        console.error(error);
    }
});
