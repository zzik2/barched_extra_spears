# 🗡️ Barched Extra Spears

> An addon mod that extends **Barched**'s Spear items to even more mods!

Barched Extra Spears automatically adds **new spear items** using materials from other mods. ⚔️  
Just install the mod, and spears will be registered whenever a supported mod is detected — no extra setup needed!

## ✨ Key Features

- 🔌 **Auto-Compat** — Spears are automatically registered when supported mods are installed
- ⚙️ **JSON Config** — Freely adjust every spear stat via JSON config files
- 🧩 **Multi-Platform** — Supports both Fabric & NeoForge (Architectury-based)
- 🎨 **Creative Tab Integration** — Items are placed naturally in each mod's creative tab

## 📦 Dependencies

| Mod | Required |
|-----|:--------:|
| [Barched](https://modrinth.com/mod/barched) | ✅ Yes |
| [Cloth Config](https://modrinth.com/mod/cloth-config) | ✅ Yes |
| [Architectury API](https://modrinth.com/mod/architectury-api) | ✅ Yes |

## 🤝 Supported Mods

<details>
<summary>🟤 <b>Bronze</b></summary>

### Bronze

When [Bronze](https://modrinth.com/mod/bronze) is installed, a bronze spear is automatically added!

**Added Items:**
- 🗡️ Bronze Spear

The bronze spear sits between iron and diamond in terms of balance, and is placed in Bronze's creative tab.

</details>

> 💡 **More mod support coming soon!** Feel free to open an issue if there's a mod you'd like to see supported 🙌

## ⚙️ Config

A default config file is automatically generated on first load.  
File path: `config/barched_extra_spears/materials/<mod_id>/<material>.json`

Example for Bronze: `config/barched_extra_spears/materials/bronze/bronze.json`

### Config File Example

```json
{
  "swingSeconds": 1.0,
  "kineticDamageMultiplier": 1.0125,
  "delaySeconds": 0.55,
  "damageCondDurationSeconds": 2.75,
  "damageCondMinSpeed": 7.75,
  "knockbackCondDurationSeconds": 6.625,
  "knockbackCondMinSpeed": 5.1,
  "dismountCondDurationSeconds": 10.625,
  "dismountCondMinRelativeSpeed": 4.6
}
```

### Attribute Reference

| Attribute | Description | Buff Direction |
|-----------|-------------|:--------------:|
| `swingSeconds` | Swing time (seconds). Attack speed = `1 / swingSeconds` | ↓ = Buff |
| `kineticDamageMultiplier` | Kinetic damage multiplier | ↑ = Buff |
| `delaySeconds` | Kinetic activation delay (seconds) | ↓ = Buff |
| `damageCondDurationSeconds` | Damage condition time window (seconds) | ↑ = Buff |
| `damageCondMinSpeed` | Minimum speed required for damage condition | ↓ = Buff |
| `knockbackCondDurationSeconds` | Knockback condition time window (seconds) | ↑ = Buff |
| `knockbackCondMinSpeed` | Minimum speed required for knockback condition | ↓ = Buff |
| `dismountCondDurationSeconds` | Dismount condition time window (seconds) | ↑ = Buff |
| `dismountCondMinRelativeSpeed` | Minimum relative speed required for dismount condition | ↓ = Buff |

> 📝 **Tip:** Duration and MinSpeed attributes work in pairs.  
> Increasing the time window while also raising the speed requirement may cancel each other out!

### Vanilla Tier Reference Values

| Tier      | swingSeconds | kineticDamage Multiplier | delay Seconds | damageCond Duration | damageCond MinSpeed | knockbackCond Duration | knockbackCond MinSpeed | dismountCond Duration | dismountCond MinRelativeSpeed |
|-----------|-------------:|-------------------------:|--------------:|--------------------:|--------------------:|-----------------------:|-----------------------:|----------------------:|------------------------------:|
| Wood      |         0.65 |                     0.70 |          0.75 |                 5.0 |                14.0 |                   10.0 |                    5.1 |                  15.0 |                           4.6 |
| Stone     |         0.75 |                     0.82 |          0.70 |                 4.5 |                10.0 |                    9.0 |                    5.1 |                 13.75 |                           4.6 |
| Copper    |         0.85 |                     0.82 |          0.65 |                 4.0 |                 9.0 |                   8.25 |                    5.1 |                  12.5 |                           4.6 |
| Iron      |         0.95 |                     0.95 |          0.60 |                 2.5 |                 8.0 |                   6.75 |                    5.1 |                 11.25 |                           4.6 |
| Gold      |         0.95 |                     0.70 |          0.70 |                 3.5 |                10.0 |                    8.5 |                    5.1 |                 13.75 |                           4.6 |
| Diamond   |         1.05 |                    1.075 |          0.50 |                 3.0 |                 7.5 |                    6.5 |                    5.1 |                  10.0 |                           4.6 |
| Netherite |         1.15 |                     1.20 |          0.40 |                 2.5 |                 7.0 |                    5.5 |                    5.1 |                  8.75 |                           4.6 |

> Use these values as a reference to create your own balance! 🎮

## 🛠️ Development Info

- **Minecraft**: 1.21.1
- **Build System**: Architectury + Loom
- **Platforms**: Fabric, NeoForge
- **Java**: 21+

## 📄 License

This project is licensed under the [MIT License](LICENSE).
