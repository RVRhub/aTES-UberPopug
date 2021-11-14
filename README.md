# aTES-UberPopug

## Event Storming

![](EventStormingATes.png)

### Auth Domain

|Command|Actor|Data|Event|
|---|---|---|---|
|Create Account|User|User Info|AccountCreated|
|Update Account|User|Auth Info|AccountUpdated|

### Task Manager Domain

|Command|Actor|Data|Event|
|---|---|---|---|
|Create Task|Account|Task|TaskCreated|
|Assign task|<TaskCreated> event|Task|TaskAssigned|
|Complete task|Account|Task|TaskCompleted|
|Bulk ReAssign|Account|???|TaskAssigned|

### Accounting Domain

|Command|Actor|Data|Event|
|---|---|---|---|
|Init invoice|Account|Task + Account|InvoiceCreated|
|Charge for Assign|<TaskAssigned> event|Task Info + Invoice data|MoneyCharged|
|Pay for Task|<TaskCompleted> event|Task Info + Invoice data|TaskPaid|
|Create daily report|Daily job|Invoice data|InvoicePerDayCreated|
|New day|<InvoicePerDayCreated> event|???|BalanceReseted|

## Data model and Domains

![](ModelATEM.png)

* Shared data marked with shaded squares
    * Task Manager Domain use Account data
    * Accounting Domain use Account data/Task Manager data
    * Audit Domain includes data from all domains and provide read only access

### Services and interactions

![](ServicesAndInteractions.png)

|Event Name|Event type|Producer|Consumers
|---|---|---|---|
|LoggedIn, AccountCreated, AccountUpdated|CUD Event|Auth Service|Accounting Service, Audit Service, TaskManager Service|
|LoggedIn|CUD Event|TaskManager Service|Audit Service|
|TaskCreated|Business Event, CUD Event|TaskManager Service|Accounting Service, Audit Service|
|TaskAssigned|Business Event, CUD Event|TaskManager Service|Accounting Service, Audit Service|
|TaskCompleted|CUD Event|TaskManager Service|Accounting Service, Audit Service|
|LoggedIn|CUD Event|Accounting Serivce|Audit Service|
|InvoiceCreated|CUD Event|Accounting Serivce|Audit Service|
|MoneyCharged|CUD Event|Accounting Serivce|Audit Service|
|MoneyPaid|CUD Event|Accounting Serivce|Audit Service|
|InvoicePerDayCreated|Business Event, CUD Event|Accounting Serivce|Accounting Service, Audit Service|
|BalanceReseted|Business Event|Accounting Service|Accounting Service, Audit Service|
