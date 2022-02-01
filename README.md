# Oil & Gas Engineering

![immagine](https://user-images.githubusercontent.com/12469744/151770759-5ab9f533-3353-4f5d-9ee4-91ad1670421a.png)

KYAAAAA! ORO NERO PER TUTTI!!

Questa mod aggiunge nuovi oggetti dell'industria del petrolio e nuovi processi petrolchimici al server RGBCraft.

## Oggetti

### Idrocarburi
|Nome|Stato|Uso|Boiler|Combustion Engine|Semifluid|Gas Turbine|
|---|---|---|---|---|---|---|
|LPG|Gas|Combustibile|:heavy_check_mark: 134 kcal/pz|:x:|:x:|:heavy_check_mark: 52 kWh|
|Gasoline|Liquido|Carburante per motori, cracking stock|:x:|:heavy_check_mark: 35 MJ, 3 ktick|:x:|:heavy_check_mark: 68 kWh|
|Naphtha|Liquido|Combustibile, cracking stock|:heavy_check_mark: 160 kcal|:heavy_check_mark: 20 MJ, 50 ktick|:x:|:heavy_check_mark: 76 kWh|
|Diesel|Liquido|Combustibile|:heavy_check_mark: 96 kcal|:heavy_check_mark: 6 MJ, 100 ktick|:x:|:x:|
|Heavy Fuel Oil|Liquido|Combustibile, cracking stock|:heavy_check_mark: 216 kcal|:x:|:heavy_check_mark: 82 kWh|:x:|
|Paraffin|Solido|Combustibile (dopo lavorazione)|:x:|:x:|:heavy_check_mark: 84 kWh|:x:|
|Mineral Oil|Solido|Lubrificante, combustibile|:x:|:x:|:heavy_check_mark: 83 kWh|:x:|
|Asphalt|Solido|Materiale da costruzione|:x:|:x:|:x:|:x:|

### Catalizzatori
|Nome|Formula|Uso|Processo|
|---|---|---|---|
|Aluminium chloride (III) Dust|AlCl₃|Cracking catalitico|Heavy Fuel Oil → Diesel|
|Platinum Dust|Pt|Cracking catalitico|Naphtha → Gasoline, Gasoline → LPG|

 ### Combustibili solidi
|Nome|Composto da|Potere calorifico|
|---|---|---|
|Wood Chips|legno|0.25 kcal/pz|
|Wood Pellets|segatura|0.45 kcal/pz|
|Paraffined Wood|segatura, paraffina|7 kcal/pz|

 ## Processi

Tutti i materiali si possono ottenere ed utilizzare con processi petrolchimici.

### Desalificazione (desalting) 

Con il Chemical Reactor:
Oil (greggio) Cell + Water Cell → Desalted Crude Cell

### Distillazione atmosferica (atmospheric distillation)

Con la Distillation Tower Gregtech
Desalted Crude Cell → Distillate Reflux,  Naphtha, Diesel, Distillate Residue

### Distillazione riflusso (reflux distillation)

Con la Distillation Tower Gregtech
Distillate Reflux Cell → LPG Cell, Gasoline Cell

### Distillazione sotto vuoto (vacuum distillation)
Distillate Residue Cell → Heavy Fuel Oil, Paraffin, Mineral Oil, Asphalt

### Cracking catalitico

vedi sezione catalizzatori

### Combustibili solidi

Con la Sawmill Gregtech
Wooden Planks → Wood Chips, Wood Pulp
Wood Chips → Wood Pulp

Con il Compressor IC²
Wood Pulp → Wood Pellet

Con l'Alloy Furnace 
Wood Pulp + Paraffin Cell → Paraffined Wood
