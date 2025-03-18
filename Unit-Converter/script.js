document.addEventListener('DOMContentLoaded', function () {
    const units = {
        length: ['Meter', 'Feet', 'Inches', 'Centimeters'],
        weight: ['Kilograms', 'Pounds', 'Ounces'],
        temperature: ['Celsius', 'Fahrenheit', 'kelvin'],
        volume: ['Liter', 'Gallons', 'Milliliters'],
        area: ['Square Meters', 'Square Feet', 'Hectares']
    };

    const tabButtons = document.querySelectorAll('.tab-button');
    const fromUnitSelect = document.getElementById('fromUnit');
    const toUnitSelect = document.getElementById('toUnit');
    const convertButton = document.getElementById('convertButton');
    const resultValue = document.getElementById('resultValue');
    const resetButton = document.getElementById('resetButton');
    const inputValue = document.getElementById('inputValue');

    let currentType = 'length';

    function updateUnits() {
        const options = units[currentType];
        fromUnitSelect.innerHTML = options.map(unit => `<option value="${unit}">${unit}</option>`).join('');
        toUnitSelect.innerHTML = options.map(unit => `<option value="${unit}">${unit}</option>`).join('');
    }

    tabButtons.forEach(button => {
        button.addEventListener('click', function () {
            tabButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');
            currentType = this.getAttribute('data-type');
            updateUnits();
        });
    });

    function convertLength(value, fromUnit, toUnit) {
        const conversions = {
            'Meter': 1,
            'Feet': 3.28084,
            'Inches': 39.3701,
            'Centimeters': 100
        };
        return value * (conversions[toUnit] / conversions[fromUnit]);
    }

    function convertWeight(value, fromUnit, toUnit) {
        const conversions = {
            'Kilograms': 1,
            'Pounds': 2.20462,
            'Ounces': 35.274
        };
        return value * (conversions[toUnit] / conversions[fromUnit]);
    }

    function convertTemperature(value, fromUnit, toUnit) {
        if (fromUnit === 'Celsius') {
            if (toUnit === 'Fahrenheit') {
                return (value * 9 / 5) + 32;
            } else if (toUnit === 'Kelvin') {
                return value + 273.15;
            }
        } else if (fromUnit === 'Fahrenheit') {
            if (toUnit === 'Celsius') {
                return (value - 32) * 5 / 9;
            } else if (toUnit === 'kelvin') {
                return (value - 32) * 5 / 9 + 273.15;
            }
        } else if (fromUnit === 'Kelvin') {
            if (toUnit === 'Celsius') {
                return value - 273.15;
            } else if (toUnit === 'Fahrenheit') {
                return (value - 273.15) * 9 / 5 + 32;
            }
        }
        return value;
    }

    function convertVolume(value, fromUnit, toUnit) {
        const conversions = {
            'Liter': 1,
            'Gallons': 0.264172,
            'Milliliters': 1000
        };
        return value * (conversions[toUnit] / conversions[fromUnit]);
    }

    function convertArea(value, fromUnit, toUnit) {
        const conversions = {
            'Square Meters': 1,
            'Square Feet': 10.7639,
            'Hectares': 0.0001
        };
        return value * (conversions[toUnit] / conversions[fromUnit]);
    }

    convertButton.addEventListener('click', function () {
        const value = parseFloat(inputValue.value);
        if (isNaN(value)) {
            alert('Enter a valid value');
            return;
        }

        const fromUnit = fromUnitSelect.value;
        const toUnit = toUnitSelect.value;

        let result;
        switch (currentType) {
            case 'length':
                result = convertLength(value, fromUnit, toUnit);
                break;
            case 'weight':
                result = convertWeight(value, fromUnit, toUnit);
                break;
            case 'temperature':
                result = convertTemperature(value, fromUnit, toUnit);
                break;
            case 'volume':
                result = convertVolume(value, fromUnit, toUnit);
                break;
            case 'area':
                result = convertArea(value, fromUnit, toUnit);
                break;
            default:
                result = value;
        }

        resultValue.textContent = `${value} ${fromUnit} = ${result.toFixed(2)} ${toUnit}`;
    });

    resetButton.addEventListener('click', function () {
        inputValue.value = '';
        resultValue.textContent = '-';
    });

    updateUnits();
});