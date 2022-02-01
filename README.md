# Oil & Gas Engineering

![immagine](https://user-images.githubusercontent.com/12469744/151770759-5ab9f533-3353-4f5d-9ee4-91ad1670421a.png)

KYAAAAA! ORO NERO PER TUTTI!!

Questa mod aggiunge nuovi oggetti dell'industria del petrolio e nuovi processi petrolchimici al server RGBCraft.

## Oggetti

### Idrocarburi
|Nome|Stato|Uso|Potere calorifico|Boiler|Combustion Engine|Semifluid|Gas Turbine|
|---|---|---|---|---|---|---|---|
|LPG|Gas|Combustibile|134 kcal/bucket|:heavy_check_mark:|:x:|:x:|:heavy_check_mark:|
|Gasoline|Liquido| |Carburante per motori, cracking stock|:x:|:heavy_check_mark:|:x:|:heavy_check_mark:|
|Naphtha|Liquido|160 kcal/bucket|Combustibile, cracking stock|:heavy_check_mark:|:x:|:x:|:heavy_check_mark:|
|Diesel|Liquido|96 kcal/bucket|Combustibile|:heavy_check_mark:|:heavy_check_mark:|:x:|:x:|
|Heavy Fuel Oil|216 kcal/bucket|Liquido|Combustibile, cracking stock|:heavy_check_mark:|:x:|:heavy_check_mark:|:x:|
|Paraffin|Solido| |Combustibile (dopo lavorazione)|:x:|:x:|:heavy_check_mark:|:x:|
|Mineral Oil|Solido| |Lubrificante, combustibile|:x:|:x:|:heavy_check_mark:|:x:|
|Asphalt|Solido| |Materiale da costruzione|:x:|:x:|:x:|:x:|

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
