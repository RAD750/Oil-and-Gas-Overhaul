# Oil & Gas Engineering

![immagine](https://user-images.githubusercontent.com/12469744/151770759-5ab9f533-3353-4f5d-9ee4-91ad1670421a.png)

KYAAAAA! ORO NERO PER TUTTI!!

Questa mod aggiunge nuovi oggetti dell'industria del petrolio e nuovi processi petrolchimici al server RGBCraft.

Possiede attualmente un macchinario dedicato, ma altri saranno aggiunti in futuro.

## Macchinari
### Well Head

Questo macchinario combina un separatore di gas, una trappola per condensato e un blowout preventer tutto in uno. 
Si piazza sopra alla Pump della Buildcraft e, mentre la pompa aspira il petrolio, lo degassa e purifica dando come risultato non solo il petrolio originale, ma anche gas naturale e condensato!

* Input:
   * Petrolio (dalla pompa)
* Output:
   * Petrolio (normale, Buildcraft)
   * Gas Metano (Gregtech)
   * Condensato (condensate)

## Oggetti

### Idrocarburi
|Nome|Stato|Uso|Boiler|Combustion Engine|Semifluid|Gas Turbine|
|---|---|---|---|---|---|---|
|LPG|Gas|Combustibile|134 kcal|:x:|:x:|52 kWh|
|Gasoline|Liquido|Carburante, cracking stock|:x:|35 MJ, 30 ktick|:x:|68 kWh|
|E85 Gasoline|Liquido|Carburante|132 kcal|30 MJ, 10 ktick|:x:|59 kWh|
|Condensate|Liquido|Va miscelato con la benzina|35 kcal|:x:|:x:|:x:|
|Naphtha|Liquido|Combustibile, cracking stock|160 kcal|20 MJ, 50 ktick|:x:|76 kWh|
|Diesel|Liquido|Combustibile|96 kcal|6 MJ, 100 ktick|:x:|:x:|
|Heavy Fuel Oil|Liquido|Combustibile, cracking stock|216 kcal|:x:|82 kWh|:x:|
|Paraffin|Solido|Combustibile (dopo lavorazione)|:x:|:x:|84 kWh|:x:|
|Mineral Oil|Solido|Lubrificante, combustibile|:x:|:x:|83 kWh|:x:|
|Asphalt|Solido|Materiale da costruzione|:x:|:x:|:x:|:x:|

### Alcoli
|Nome|Stato|Uso|Boiler|Combustion Engine|Semifluid|Gas Turbine|
|---|---|---|---|---|---|---|
|Ethanol|Liquido|Combustibile|105 kcal|:x:|:x:|29 kWh|

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

### Degassamento

Va effettuato alla pompa, piazzandoci direttamente sopra un Well Head.

Permette di recuperare metano e condensato che altrimenti andrebbero perduti.

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

### Miscelazione

Permette di recuperare il condensato
Con il Chemical Reactor:

Condensate, Gasoline → Gasoline

### Steam cracking

Permette di produrre etilene.
Con il Chemical Reactor:
Naphtha + 2H2+O2 Cell → Ethylene
Condensate + 2H2+O2 Cell → Ethylene

### Esterificazione

Permette di fare il solfato di etile, che va usato per l'etanolo.
Con l'Alloy Smelter:

Ethylene, H2SO4 → Ethyl sulfate

### Idrolisi catalitica

Permette di produrre etanolo e recuperare l'acido solforico.
Con la Blast Furnace:

Ethyl sulfate + 2H2+O2 Cell → Ethanol + H2SO4

### Miscelazione etanolo

Si può miscelare l'etanolo con la benzina nel Chemical reactor con una percentuale dell'85%, per risparmiare benzina.

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
